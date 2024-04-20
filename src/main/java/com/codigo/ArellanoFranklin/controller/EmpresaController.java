package com.codigo.ArellanoFranklin.controller;

import aj.org.objectweb.asm.Opcodes;
import com.codigo.ArellanoFranklin.entity.EmpresaEntity;
import com.codigo.ArellanoFranklin.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API DE MANTENIMIENTO EMPRESA",
        description = "Esta api tiene todos los endpoints para realizar el mantenimiento de la entidad empresa"
)
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(
            summary = "Crear una nueva empresa",
            description = "Para usar este endPoint debes enviarme un objeto empresa, lo cual se va a guardar en Base de datos",
            parameters = {
                    @Parameter(name = "razonSocial", description = "Razon social de la empresa" ),
                    @Parameter(name = "tipoDocumento", description = "Tipo de documento de la empresa" ),
                    @Parameter(name = "numeroDocumento", description = "Numero de documento de la empresa" ),
                    @Parameter(name = "condicion", description = "Condicion de la empresa" ),
                    @Parameter(name = "direccion", description = "Direccion de la empresa" ),
                    @Parameter(name = "distrito", description = "Distrito de la empresa" ),
                    @Parameter(name = "provincia", description = "Provincia de la empresa" ),
                    @Parameter(name = "departamento", description = "Departamento de la empresa" ),
                    @Parameter(name = "EsAgenteRetencion", description = "Variable booleana(True o False) que identifica si es agente de retencion" ),
            }
    )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200",description = "Persona creada exitosamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.crear(empresaEntity));
    }
    @Operation(
            summary = "busca empresa por id",
            description = "Para usar este endPoint debes enviar un id de empresa, lo cual consulta en Base de datos previa validacion",
            parameters = {
                    @Parameter(name= "id", description = "id de empleado")
            }
    )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200",description = "Empresa encontrada exitosamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))}),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarxid(id));
    }
    @Operation(summary = "Lista todas las Empresas")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200",description = "Empresas encontrada exitosamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> listarTodos(){
        return ResponseEntity.ok(empresaService.buscarAll());
    }
    @Operation(
            summary = "Actualiza empresa por id",
            description = "Para usar este endPoint debes enviarme un objeto empresa y su id, lo cual se va a actualizara los campos en la en Base de datos",
            parameters = {
                    @Parameter(name = "razonSocial", description = "Razon social de la empresa" ),
                    @Parameter(name = "tipoDocumento", description = "Tipo de documento de la empresa" ),
                    @Parameter(name = "numeroDocumento", description = "Numero de documento de la empresa" ),
                    @Parameter(name = "condicion", description = "Condicion de la empresa" ),
                    @Parameter(name = "direccion", description = "Direccion de la empresa" ),
                    @Parameter(name = "distrito", description = "Distrito de la empresa" ),
                    @Parameter(name = "provincia", description = "Provincia de la empresa" ),
                    @Parameter(name = "departamento", description = "Departamento de la empresa" ),
                    @Parameter(name = "EsAgenteRetencion", description = "Variable booleana(True o False) que identifica si es agente de retencion" ),
            }
    )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200",description = "Empresa actualizada exitosamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.actualizar(id, empresaEntity));
    }
    @Operation(
            summary = "Elimina empresa por id",
            description = "Para usar este endPoint debes enviar un id de empresa, lo cual elimina en Base de datos previa validacion",
            parameters = {
                    @Parameter(name= "id", description = "id de empresa")
            }
    )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200",description = "Empresa eliminada exitosamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.borrar(id));
    }
}
