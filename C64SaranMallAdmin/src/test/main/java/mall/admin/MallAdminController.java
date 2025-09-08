package mall.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class MallAdminController {

    @Autowired
    private MallAdminService mallAdminService;

    // CREATE
    @PostMapping
    public ResponseEntity<MallAdmin> register(@RequestBody MallAdmin admin) {
        MallAdmin saved = mallAdminService.registerAdmin(admin);
        return ResponseEntity.ok(saved);
    }

    // READ: All Admins
    @GetMapping
    public ResponseEntity<List<MallAdmin>> getAllAdmins() {
        List<MallAdmin> admins = mallAdminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // READ: One Admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<MallAdmin> getAdminById(@PathVariable Integer id) {
        MallAdmin admin = mallAdminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<MallAdmin> updateAdmin(@PathVariable Integer id, @RequestBody MallAdmin updatedAdmin) {
        MallAdmin admin = mallAdminService.updateAdmin(id, updatedAdmin);
        return ResponseEntity.ok(admin);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Integer id) {
        mallAdminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin with ID " + id + " deleted successfully.");
    }
}


