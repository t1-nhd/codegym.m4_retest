package codegym.m4_retest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLoaiSP;
    private String tenLoaiSP;

    @OneToMany(mappedBy = "loaiSanPham")
    List<SanPham> sanPhams;
}
