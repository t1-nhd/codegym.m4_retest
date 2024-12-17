package codegym.m4_retest.repository;

import codegym.m4_retest.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISanPhamRepository extends JpaRepository<SanPham, Long> {
}
