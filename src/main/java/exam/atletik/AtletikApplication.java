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
            deltager.setKlub("A");

            Deltager deltager2 = new Deltager();
            deltager2.setNavn("Sofie");
            deltager2.setAlder(22);
            deltager2.setKøn("Kvinde");
            deltager2.setKlub("B");

            Deltager deltager3 = new Deltager();
            deltager3.setNavn("Mads");
            deltager3.setAlder(30);
            deltager3.setKøn("Mand");
            deltager3.setKlub("B");

            Deltager deltager4 = new Deltager();
            deltager4.setNavn("Jens");
            deltager4.setAlder(40);
            deltager4.setKøn("Mand");
            deltager4.setKlub("D");

            Deltager deltager5 = new Deltager();
            deltager5.setNavn("Emma");
            deltager5.setAlder(22);
            deltager5.setKøn("Kvinde");
            deltager5.setKlub("E");

            Deltager deltager6 = new Deltager();
            deltager6.setNavn("Niels");
            deltager6.setAlder(35);
            deltager6.setKøn("Mand");
            deltager6.setKlub("A");

            Deltager deltager7 = new Deltager();
            deltager7.setNavn("Laura");
            deltager7.setAlder(29);
            deltager7.setKøn("Kvinde");
            deltager7.setKlub("E");

            Deltager deltager8 = new Deltager();
            deltager8.setNavn("Henrik");
            deltager8.setAlder(45);
            deltager8.setKøn("Mand");
            deltager8.setKlub("C");

            Deltager deltager9 = new Deltager();
            deltager9.setNavn("Camilla");
            deltager9.setAlder(31);
            deltager9.setKøn("Kvinde");
            deltager9.setKlub("E");

            Deltager deltager10 = new Deltager();
            deltager10.setNavn("Peter");
            deltager10.setAlder(27);
            deltager10.setKøn("Mand");
            deltager10.setKlub("A");

            Disciplin disciplin = new Disciplin();
            disciplin.setNavn("100 meter");
            disciplin.setResultatType("Tid");
            disciplinRepository.save(disciplin);


            Disciplin disciplin2 = new Disciplin();
            disciplin2.setNavn("Længdespring");
            disciplin2.setResultatType("Meter");
            disciplinRepository.save(disciplin2);

            Disciplin disciplin3 = new Disciplin();
            disciplin3.setNavn("Højdespring");
            disciplin3.setResultatType("Meter");
            disciplinRepository.save(disciplin3);

            Disciplin disciplin4 = new Disciplin();
            disciplin4.setNavn("Kuglestød");
            disciplin4.setResultatType("Meter");
            disciplinRepository.save(disciplin4);

            Disciplin disciplin5 = new Disciplin();
            disciplin5.setNavn("Diskoskast");
            disciplin5.setResultatType("Meter");
            disciplinRepository.save(disciplin5);

            Disciplin disciplin6 = new Disciplin();
            disciplin6.setNavn("Spydkast");
            disciplin6.setResultatType("Meter");
            disciplinRepository.save(disciplin6);

            Disciplin disciplin7 = new Disciplin();
            disciplin7.setNavn("400m løb");
            disciplin7.setResultatType("Sekunder");
            disciplinRepository.save(disciplin7);

            Disciplin disciplin8 = new Disciplin();
            disciplin8.setNavn("1500m løb");
            disciplin8.setResultatType("Minutter");
            disciplinRepository.save(disciplin8);

            Disciplin disciplin9 = new Disciplin();
            disciplin9.setNavn("5km løb");
            disciplin9.setResultatType("Minutter");
            disciplinRepository.save(disciplin9);

            Disciplin disciplin10 = new Disciplin();
            disciplin10.setNavn("10km løb");
            disciplin10.setResultatType("Minutter");
            disciplinRepository.save(disciplin10);



            deltager.setDiscipliner(Arrays.asList(disciplin, disciplin2));
            deltager2.setDiscipliner(Arrays.asList(disciplin, disciplin2, disciplin3));

            deltagerRepository.save(deltager);
            deltagerRepository.save(deltager2);
            deltagerRepository.save(deltager3);
            deltagerRepository.save(deltager4);
            deltagerRepository.save(deltager5);
            deltagerRepository.save(deltager6);
            deltagerRepository.save(deltager7);
            deltagerRepository.save(deltager8);
            deltagerRepository.save(deltager9);
            deltagerRepository.save(deltager10);


            Resultat resultat1 = new Resultat();
            resultat1.setDeltager(deltager);
            resultat1.setDisciplin(disciplin2);
            resultat1.setDato(java.time.LocalDateTime.now());
            resultat1.setResultat(6.5);
            resultatRepository.save(resultat1);

            Resultat resultat2 = new Resultat();
            resultat2.setDeltager(deltager2);
            resultat2.setDisciplin(disciplin2);
            resultat2.setDato(java.time.LocalDateTime.now());
            resultat2.setResultat(12.3);
            resultatRepository.save(resultat2);

            Resultat resultat3 = new Resultat();
            resultat3.setDeltager(deltager3);
            resultat3.setDisciplin(disciplin3);
            resultat3.setDato(java.time.LocalDateTime.now());
            resultat3.setResultat(24.7);
            resultatRepository.save(resultat3);

            Resultat resultat4 = new Resultat();
            resultat4.setDeltager(deltager4);
            resultat4.setDisciplin(disciplin3);
            resultat4.setDato(java.time.LocalDateTime.now());
            resultat4.setResultat(15.5);
            resultatRepository.save(resultat4);

            Resultat resultat5 = new Resultat();
            resultat5.setDeltager(deltager5);
            resultat5.setDisciplin(disciplin5);
            resultat5.setDato(java.time.LocalDateTime.now());
            resultat5.setResultat(32.1);
            resultatRepository.save(resultat5);

            Resultat resultat6 = new Resultat();
            resultat6.setDeltager(deltager5);
            resultat6.setDisciplin(disciplin6);
            resultat6.setDato(java.time.LocalDateTime.now());
            resultat6.setResultat(45.6);
            resultatRepository.save(resultat6);

            Resultat resultat7 = new Resultat();
            resultat7.setDeltager(deltager7);
            resultat7.setDisciplin(disciplin9);
            resultat7.setDato(java.time.LocalDateTime.now());
            resultat7.setResultat(22.4);
            resultatRepository.save(resultat7);

            Resultat resultat8 = new Resultat();
            resultat8.setDeltager(deltager8);
            resultat8.setDisciplin(disciplin8);
            resultat8.setDato(java.time.LocalDateTime.now());
            resultat8.setResultat(3.5);
            resultatRepository.save(resultat8);

            Resultat resultat9 = new Resultat();
            resultat9.setDeltager(deltager9);
            resultat9.setDisciplin(disciplin9);
            resultat9.setDato(java.time.LocalDateTime.now());
            resultat9.setResultat(19.6);
            resultatRepository.save(resultat9);

            Resultat resultat10 = new Resultat();
            resultat10.setDeltager(deltager10);
            resultat10.setDisciplin(disciplin10);
            resultat10.setDato(java.time.LocalDateTime.now());
            resultat10.setResultat(42.7);
            resultatRepository.save(resultat10);


        };
    }

}
