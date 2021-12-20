package id.oneindoensia.javabootcamp.day5.projectlombok;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Data
public class Mahasiswa extends Person {

    private final int nim;
    private final String name;
    private double noRekening;
    private String address;

    @SneakyThrows
    public Connection getConnection(String newFile) {
        @Cleanup
        Connection connectionToDataSources
                = DriverManager.getConnection("");
        log.info("Load file {}", newFile);
        return connectionToDataSources;
    }

    private final Object someObject = new Object();

    @Synchronized(value = "someObject")
    public void creditAccount(double incomingCredit){
        noRekening = noRekening + incomingCredit;
    }

    @Synchronized(value = "someObject")
    public double getNoRekening(){
        return  noRekening;
    }
}
