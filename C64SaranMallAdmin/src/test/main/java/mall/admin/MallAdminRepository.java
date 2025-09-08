package mall.admin;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MallAdminRepository extends JpaRepository<MallAdmin, Integer> {
    boolean existsByEmail(String email);
}
