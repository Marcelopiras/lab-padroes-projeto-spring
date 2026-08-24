package one.digitalinovation.gof.controller;

import jakarta.validation.Valid;
import one.digitalinovation.gof.model.Cliente;
import one.digitalinovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping("clientes")

    public class ClienteRestController {

            @Autowired
        private ClienteService clienteService;

            @GetMapping
        public ResponseEntity<Iterable<Cliente>> buscarTodos() {
            return ResponseEntity.ok(clienteService.buscarTodos());
    }

            @GetMapping ("/{id}")
        public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
                return ResponseEntity.ok(clienteService.buscarPorId(id));
            }

            @GetMapping ("/nome/{nome}")
        public ResponseEntity<Iterable<Cliente>> buscarNome(@PathVariable String nome) {
                return ResponseEntity.ok(clienteService.buscarNome(nome));
            }

            @PostMapping
        public ResponseEntity<Cliente> inserir(@RequestBody @Valid Cliente cliente) {
                clienteService.inserir(cliente);
                return ResponseEntity.ok(cliente);
            }

            @PutMapping ("/{id}")
        public  ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
                clienteService.atualizar(id,cliente);
                return ResponseEntity.ok(cliente);
            }

            @DeleteMapping ("/{id}")
        public ResponseEntity<Cliente> deletar(@PathVariable Long id) {
                clienteService.deletar(id);
                return ResponseEntity.ok().build();
            }
}