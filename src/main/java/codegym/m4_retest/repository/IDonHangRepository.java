package codegym.m4_retest.repository;


import codegym.m4_retest.model.DonHang;
import codegym.m4_retest.model.DonHangDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonHangRepository extends JpaRepository<DonHang, Long> {
    @Query(value = "select *, (dh.so_luong * sp.giasp) as tong_tien" +
            "from don_hang dh join san_pham sp" +
            "    on dh.masp = sp.masp" +
            "    join loai_san_pham lsp on sp.ma_loaisp = lsp.ma_loaisp" +
            "order by tong_tien desc limit :top", nativeQuery = true)
    List<DonHangDTO> topDoanhThu(@Param("top") int top);
}
