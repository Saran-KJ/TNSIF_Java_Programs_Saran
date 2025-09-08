package mall.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository mallAdminRepository;

    // CREATE: Register new admin
    public MallAdmin registerAdmin(MallAdmin admin) {
        return mallAdminRepository.save(admin);
    }

    // READ: Get all admins
    public List<MallAdmin> getAllAdmins() {
        return mallAdminRepository.findAll();
    }

    // READ: Get admin by ID
    public MallAdmin getAdminById(Integer id) {
        return mallAdminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
    }

    // UPDATE: Update existing admin
    public MallAdmin updateAdmin(Integer id, MallAdmin updatedAdmin) {
        MallAdmin existing = getAdminById(id);

        existing.setUsername(updatedAdmin.getUsername());
        existing.setEmail(updatedAdmin.getEmail());
        existing.setPassword(updatedAdmin.getPassword());
        existing.setIsActive(updatedAdmin.getIsActive());
        existing.setLoginAttempts(updatedAdmin.getLoginAttempts());
        existing.setLastLoginTime(updatedAdmin.getLastLoginTime());

        return mallAdminRepository.save(existing);
    }

    // DELETE: Remove admin by ID
    public void deleteAdmin(Integer id) {
        if (!mallAdminRepository.existsById(id)) {
            throw new RuntimeException("Admin not found with ID: " + id);
        }
        mallAdminRepository.deleteById(id);
    }
}
