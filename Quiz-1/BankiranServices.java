package ir.freeland.spring.selectbean.service;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface BankiranServices {
    File accountTransaction(String accountNumber);
}