package dio.designpatterns.gof.service;

import dio.designpatterns.gof.model.Adress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Adress ConsultCep(@PathVariable("cep") String cep);
}
