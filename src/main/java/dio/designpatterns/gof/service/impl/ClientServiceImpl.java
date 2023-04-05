package dio.designpatterns.gof.service.impl;

import dio.designpatterns.gof.model.AdressRepository;
import dio.designpatterns.gof.model.Client;
import dio.designpatterns.gof.model.ClientRepository;
import dio.designpatterns.gof.service.ClientService;
import dio.designpatterns.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public Client getById(Long id) {
        return null;
    }

    @Override
    public void insert(Client client) {

    }

    @Override
    public void update(Long id, Client client) {

    }

    @Override
    public void delete(Long id) {

    }
}
