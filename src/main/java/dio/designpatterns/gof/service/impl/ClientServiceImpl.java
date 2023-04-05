package dio.designpatterns.gof.service.impl;

import dio.designpatterns.gof.model.Adress;
import dio.designpatterns.gof.model.AdressRepository;
import dio.designpatterns.gof.model.Client;
import dio.designpatterns.gof.model.ClientRepository;
import dio.designpatterns.gof.service.ClientService;
import dio.designpatterns.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientInDB = clientRepository.findById(id);
        if (clientInDB.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAdress().getCep();
        Adress adress = adressRepository.findById(cep).orElseGet(() -> {
            Adress newAdress = viaCepService.ConsultCep(cep);
            adressRepository.save(newAdress);
            return newAdress;
        });
        client.setAdress(adress);
        clientRepository.save(client);
    }
}
