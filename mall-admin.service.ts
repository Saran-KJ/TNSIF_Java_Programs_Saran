import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class MallAdminService {
  API = "http://localhost:9090";

  constructor(private http: HttpClient) {}

  // Create a new mall admin
  public createMallAdmin(adminData: any) {
    return this.http.post(`${this.API}/admin`, adminData);
  }

  // Get all mall admins
  public getMallAdmins() {
    return this.http.get(`${this.API}/admin`);
  }

  // Delete a mall admin by ID
  public deleteMallAdmin(adminId: number) {
    return this.http.delete(`${this.API}/admin/${adminId}`);
  }

  // Update a mall admin
  public updateMallAdmin(admin: any) {
    const adminId = admin.mallAdminId;
    return this.http.put(`${this.API}/admin/${adminId}`, admin);
  }
}
