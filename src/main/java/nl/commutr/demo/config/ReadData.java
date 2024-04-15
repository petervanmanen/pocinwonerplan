package nl.commutr.demo.config;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import nl.commutr.demo.domain.aanbod.Aanbod;
import nl.commutr.demo.domain.aanbod.AanbodActiviteit;
import nl.commutr.demo.domain.aanbod.Aandachtspunt;
import nl.commutr.demo.domain.aanbod.Actiehouder;
import nl.commutr.demo.domain.aanbod.Ontwikkelwens;
import nl.commutr.demo.domain.aanbod.Subdoel;
import nl.commutr.demo.repository.AanbodActiviteitRepository;
import nl.commutr.demo.repository.AanbodRepository;
import nl.commutr.demo.repository.AandachtspuntRepository;
import nl.commutr.demo.repository.ActiehouderRepository;
import nl.commutr.demo.repository.InwonerplanRepository;
import nl.commutr.demo.repository.OntwikkelwensRepository;
import nl.commutr.demo.repository.SubdoelRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
public class ReadData {


    InwonerplanRepository repository;

    AanbodRepository aanbodRepository;

    AanbodActiviteitRepository aanbodActiviteitRepository;

    AandachtspuntRepository aandachtspuntRepository;

    OntwikkelwensRepository ontwikkelwensRepository;

    SubdoelRepository subdoelRepository;

    ActiehouderRepository actiehouderRepository;

    public ReadData(InwonerplanRepository repository, AanbodRepository aanbodRepository, AanbodActiviteitRepository aanbodActiviteitRepository, AandachtspuntRepository aandachtspuntRepository, SubdoelRepository subdoelRepository,  OntwikkelwensRepository ontwikkelwensRepository, ActiehouderRepository actiehouderRepository) {
        this.repository = repository;
        this.aanbodRepository = aanbodRepository;
        this.aanbodActiviteitRepository = aanbodActiviteitRepository;
        this.aandachtspuntRepository = aandachtspuntRepository;
        this.subdoelRepository = subdoelRepository;
        this.ontwikkelwensRepository = ontwikkelwensRepository;
        this.actiehouderRepository = actiehouderRepository;
        readTestData();
    }

    public void readTestData() {
        readActiehouders();
        readAandachtspunten();
        readOntwikkelwensen();
        readAanbodActiviteiten();
        readSubdoelen();
        readAanbod();
    }
    private void readActiehouders() {
        actiehouderRepository.saveAll(loadObjectList(Actiehouder.class, "data/actiehouder.csv"));
    }
    private void readAandachtspunten() {
        aandachtspuntRepository.saveAll(loadObjectList(Aandachtspunt.class, "data/aandachtspunten.csv"));
    }
    private void readOntwikkelwensen() {
        ontwikkelwensRepository.saveAll(loadObjectList(Ontwikkelwens.class, "data/ontwikkelwensen.csv"));
    }
    private void readAanbodActiviteiten() {
        aanbodActiviteitRepository.saveAll(loadObjectList(AanbodActiviteit.class, "data/aanbodactiviteit.csv"));
    }

    private void readAanbod(){
        List<Aanbod> aanbods = loadObjectList(Aanbod.class,"data/aanbod.csv");
        for(Aanbod aanbod: aanbods){
            for(String activiteit: aanbod.activiteiten.split("\t")){
                System.out.println("Activiteit: " + activiteit.trim());
                AanbodActiviteit a = aanbodActiviteitRepository.getAanbodActiviteitByNaamaanbodactiviteitIgnoreCase(activiteit.trim());
                System.out.println("Resolved activitieit: " + a.getNaamaanbodactiviteit());
                aanbod.addActiviteit(a);
            }
        }
        for(Aanbod aanbod: aanbods){
            System.out.println(aanbod.getNaam());
            for(String code: aanbod.subdoel.split(" ")){
                Subdoel s = subdoelRepository.getSubdoelByCode(code);
                System.out.println(s.getNaam() + " -" + code + "-" + s.getCode() + s.getUuid());
                aanbod.addSubdoel(s);
            }
        }
        aanbodRepository.saveAll(aanbods);
    }

    private void readSubdoelen() {
        List<Subdoel> subdoelen = loadObjectList(Subdoel.class, "data/subdoelen.csv");
        for(Subdoel subdoel: subdoelen){
            for(String code: subdoel.getAandachtspuntenCodes().split(" ")){
                Aandachtspunt aandachtspunt = aandachtspuntRepository.getAandachtspuntByCode(code);
                if(aandachtspunt!=null) {
                    subdoel.addAandachtspunt(aandachtspunt);
                }
                Ontwikkelwens ontwikkelwens = ontwikkelwensRepository.getOntwikkelwensByCode(code);
                if(ontwikkelwens!=null){
                    subdoel.addOntwikkelwens(ontwikkelwens);
                }
            }
        }
        subdoelRepository.saveAll(subdoelen);
    }

    private <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();

            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while loading object list from file " + fileName);
            return Collections.emptyList();
        }
    }

    public List<String[]> loadManyToManyRelationship(String fileName) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<String[]> readValues =
                    mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(
                    "Error occurred while loading many to many relationship from file = " + fileName);
            return Collections.emptyList();
        }
    }
}
