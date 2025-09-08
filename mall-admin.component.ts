import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MallAdminService } from './mall-admin.service';

export interface MallAdmin {
  mallAdminId?: number;
  username: string;
  password: string;
  email: string;
  loginAttempts: number;
  isActive: boolean;
  lastLoginTime?: string;
}

@Component({
  selector: 'app-mall-admin-root',
  templateUrl: './mall-admin.component.html',
  styleUrls: ['./mall-admin.component.scss']
})
export class MallAdminComponent implements OnInit {
  get validMallAdmins(): MallAdmin[] {
    return this.mallAdmins.filter(a => a.username && a.email);
  }
  title = 'malladmin';

  mallAdmins: MallAdmin[] = [];
  mallAdminForm: MallAdmin = {
    username: '',
    password: '',
    email: '',
    loginAttempts: 0,
    isActive: true
  };
  editing: boolean = false;
  editAdmin: MallAdmin | null = null;
  errorMessage: string = '';
  loading: boolean = false;

  constructor(private mallAdminService: MallAdminService) {}

  ngOnInit(): void {
    this.loadMallAdmins();
  }

  loadMallAdmins(): void {
    this.loading = true;
    this.errorMessage = '';
    this.mallAdminService.getMallAdmins().subscribe({
      next: (data: any) => {
        if (Array.isArray(data)) {
          this.mallAdmins = data;
        } else if (data && data.content && Array.isArray(data.content)) {
          this.mallAdmins = data.content;
        } else {
          this.mallAdmins = [];
        }
        this.loading = false;
        console.log('Loaded mallAdmins:', this.mallAdmins);
      },
      error: (err) => {
        this.errorMessage = 'Failed to load admins.';
        this.loading = false;
        console.error('Error loading admins:', err);
      }
    });
  }

  register(registerForm: NgForm): void {
    this.loading = true;
    this.errorMessage = '';
    this.mallAdminService.createMallAdmin(this.mallAdminForm).subscribe({
      next: () => {
        this.loadMallAdmins();
        this.resetForm();
        registerForm.reset();
        this.loading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to register admin.';
        this.loading = false;
        console.error('Error registering admin:', err);
      }
    });
  }

  editMallAdmin(admin: MallAdmin): void {
    this.editAdmin = { ...admin };
    this.editing = true;
    // Optionally, set mallAdminForm to editAdmin for two-way binding
    this.mallAdminForm = { ...admin };
  }

  updateMallAdmin(): void {
    if (!this.editAdmin) return;
    this.loading = true;
    this.errorMessage = '';
    this.mallAdminService.updateMallAdmin(this.mallAdminForm).subscribe({
      next: () => {
        this.loadMallAdmins();
        this.resetForm();
        this.editing = false;
        this.editAdmin = null;
        this.loading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to update admin.';
        this.loading = false;
        console.error('Error updating admin:', err);
      }
    });
  }

  deleteMallAdmin(admin: MallAdmin): void {
    if (!admin.mallAdminId) return;
    this.loading = true;
    this.errorMessage = '';
    this.mallAdminService.deleteMallAdmin(admin.mallAdminId).subscribe({
      next: () => {
        this.loadMallAdmins();
        this.loading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to delete admin.';
        this.loading = false;
        console.error('Delete failed', err);
      }
    });
  }

  resetForm(): void {
    this.mallAdminForm = {
      username: '',
      password: '',
      email: '',
      loginAttempts: 0,
      isActive: true
    };
    this.editing = false;
    this.editAdmin = null;
  }
}

