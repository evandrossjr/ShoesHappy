package com.sh.sistema;


import com.sh.sistema.entities.Client;
import com.sh.sistema.entities.enuns.Modality;
import com.sh.sistema.repository.ClientRepository;
import com.sh.sistema.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client(2016, "Freya","Iguatemi", Modality.EAD);
        Client c2 = new Client(2018, "Kali","Nordeste",Modality.PRESENCIAL);
        Client c3 = new Client(2024,"Isis","São Cristóvão",Modality.SEMIPRESENCIAL);
        Client c4 = new Client(2025, "Luna","São Cristóvão",Modality.EAD);
        Client c5 = new Client(2016, "Hecate","Federação",Modality.PRESENCIAL);

        clientRepository.saveAll(Arrays.asList(c1, c2, c3,c4,c5));
    }
}
