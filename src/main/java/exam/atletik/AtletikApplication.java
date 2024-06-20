package exam.atletik;

import exam.atletik.entity.Deltager;
import exam.atletik.entity.Disciplin;
import exam.atletik.entity.Resultat;
import exam.atletik.repository.DeltagerRepository;
import exam.atletik.repository.DisciplinRepository;
import exam.atletik.repository.ResultatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class AtletikApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtletikApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository, ResultatRepository resultatRepository){
        return args -> {
            Deltager deltager = new Deltager();
            deltager.setNavn("Hans");
            deltager.setAlder(25);
            deltager.setKøn("Mand");
            deltager.setKlub("KIF");

            Deltager deltager2 = new Deltager();
            deltager2.setNavn("Sofie");
            deltager2.setAlder(22);
            deltager2.setKøn("Kvinde");
            deltager2.setKlub("KIF");

            Deltager deltager3 = new Deltager();
            deltager3.setNavn("Mads");
            deltager3.setAlder(30);
            deltager3.setKøn("Mand");
            deltager3.setKlub("UFV");

            Disciplin disciplin = new Disciplin();
            disciplin.setNavn("100 meter");
            disciplin.setResultatType("Tid");

            Disciplin disciplin2 = new Disciplin();
            disciplin2.setNavn("Længdespring");
            disciplin2.setResultatType("Meter");

            Disciplin disciplin3 = new Disciplin();
            disciplin3.setNavn("Højdespring");
            disciplin3.setResultatType("Meter");

            disciplinRepository.save(disciplin);
            disciplinRepository.save(disciplin2);
            disciplinRepository.save(disciplin3);

            deltager.setDiscipliner(Arrays.asList(disciplin, disciplin2));
            deltager2.setDiscipliner(Arrays.asList(disciplin, disciplin2, disciplin3));

            deltagerRepository.save(deltager);
            deltagerRepository.save(deltager2);
            deltagerRepository.save(deltager3);

            Resultat resultat1 = new Resultat();
            resultat1.setDeltager(deltager);
            resultat1.setDisciplin(disciplin2);
            resultat1.setDato(java.time.LocalDateTime.now());
            resultat1.setResultat(6.5);
            resultatRepository.save(resultat1);


        };
    }

}
