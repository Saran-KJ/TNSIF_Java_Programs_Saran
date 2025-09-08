import { TestBed } from '@angular/core/testing';
import { MallAdminComponent } from './mall-admin.component';

describe('MallAdminComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MallAdminComponent],
    }).compileComponents();
  });

  it('should create the component', () => {
    const fixture = TestBed.createComponent(MallAdminComponent);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });

  it(`should have as title 'malladmin'`, () => {
    const fixture = TestBed.createComponent(MallAdminComponent);
    const component = fixture.componentInstance;
    expect(component.title).toEqual('malladmin');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(MallAdminComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.textContent).toContain('Mall Admin');
  });
});
