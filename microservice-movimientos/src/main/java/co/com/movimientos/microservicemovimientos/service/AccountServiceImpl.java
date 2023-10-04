package co.com.movimientos.microservicemovimientos.service;

import co.com.movimientos.microservicemovimientos.dto.ClientDTO;
import co.com.movimientos.microservicemovimientos.dto.ResponseDTO;
import co.com.movimientos.microservicemovimientos.model.Account;
import co.com.movimientos.microservicemovimientos.model.AccountType;
import co.com.movimientos.microservicemovimientos.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Service
public class AccountServiceImpl implements AccountService{

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseDTO getClientByIdentification(int identification){
        ResponseDTO responseDTO = new ResponseDTO();
//        ResponseEntity<ClientDTO> responseEntity = restTemplate.getForEntity("http://localhost:3333/clients/"+identification,ClientDTO.class);
        ResponseEntity<ClientDTO> responseEntity = restTemplate.exchange("http://localhost:3333/clients/"+identification, HttpMethod.GET, new HttpEntity<>(createHeaders(SECURE_KEY_USERNAME,SECURE_KEY_PASSWORD)), ClientDTO.class);
        ClientDTO clientDTO = responseEntity.getBody();
        responseDTO.setClientDTO(clientDTO);
        return responseDTO;
    }

    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders(){{
            String auht = username+":"+password;
            byte[] encodedAuht = Base64.getEncoder().encode(auht.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic "+new String(encodedAuht);
            set("Authorization",authHeader);
        }};
    }

    @Override
    public Account saveAccount(Account account){
        if (account.getAccountType().equals("Ahorros")){
            account.setAccountType(AccountType.Ahorros);
        }else {
            account.setAccountType(AccountType.Corriente);
        }
        return accountRepository.save(account);
    }
}
