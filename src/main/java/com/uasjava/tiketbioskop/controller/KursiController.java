package com.uasjava.tiketbioskop.controller;
import com.uasjava.tiketbioskop.dto.*;
import com.uasjava.tiketbioskop.service.*;
import com.uasjava.tiketbioskop.util.WebResponse;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// @RequestMapping("/api/kursi")
@RequiredArgsConstructor
public class KursiController {
    private final KursiService kursiService;

    @PostMapping("/admin/kursi")
    @Operation(summary = "Menambah kursi baru")
    public ResponseEntity<WebResponse<KursiDTO>> create(@Valid @RequestBody KursiDTO dto) {
        return ResponseEntity.ok(new WebResponse<>(200, "Berhasil tambah", kursiService.create(dto)));
    }

    @GetMapping("/all/kursi")
    @Operation(summary = "Menampilkan semua kursi baru")
    public ResponseEntity<WebResponse<Page<KursiDTO>>> getAll(Pageable pageable) {
        return ResponseEntity.ok(new WebResponse<>(200, "Berhasil ambil data", kursiService.getAll(pageable)));
    }

    @GetMapping("/all/kursi/{id}")
    @Operation(summary = "Menampilkan kursi berdasarkan id ")
    public ResponseEntity<WebResponse<KursiDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new WebResponse<>(200, "Berhasil ambil data", kursiService.getById(id)));
    }

    @PutMapping("/admin/kursi/{id}")
    @Operation(summary = "Mengubah kursi berdasarkan id")
    public ResponseEntity<WebResponse<KursiDTO>> update(@PathVariable Long id, @Valid @RequestBody KursiDTO dto) {
        return ResponseEntity.ok(new WebResponse<>(200, "Berhasil update", kursiService.update(id, dto)));
    }

    @DeleteMapping("/admin/kursi/{id}")
    @Operation(summary = "Menghapus kursi berdasarkan id")
    public ResponseEntity<WebResponse<String>> delete(@PathVariable Long id) {
        kursiService.delete(id);
        return ResponseEntity.ok(new WebResponse<>(200, "Berhasil hapus", "OK"));
    }
}

