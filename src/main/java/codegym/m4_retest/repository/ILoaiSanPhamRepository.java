package codegym.m4_retest.repository;

import codegym.m4_retest.model.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Long> {
}
