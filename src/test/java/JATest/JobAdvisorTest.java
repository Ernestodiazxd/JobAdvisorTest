package JATest;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobAdvisorTest {

    private static Empresa empresa;
    private static Lloc lloc1;
    private static Lloc lloc2;
    private static Opinio opinio1;

    @Test
    public void test1crearEmpresaTest() {
        //Crear una empresa (mínim 2)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        Empresa empresaACrear = new Empresa();
        empresaACrear.setNomEmpresa("Empresa de Test");
        empresaACrear.setAdreca("Pau Claris 118");
        empresaACrear.setPoblacio("Barcelona");
        empresaACrear.setSector("IT");
        empresaACrear.setSocietat("SL");
        empresaACrear.setNtreballadors(89L);


        HttpEntity<Empresa> entity = new HttpEntity<>(empresaACrear);
        ResponseEntity<Empresa> result = testRestTemplate.exchange("http://localhost:8080/empresa", HttpMethod.POST,entity, Empresa.class);


        Assert.assertEquals(200,result.getStatusCodeValue());
        Empresa empresaResult = result.getBody();
        Assert.assertEquals(empresaACrear.getNomEmpresa(),empresaResult.getNomEmpresa());
        Assert.assertNotNull(empresaResult.getIdEmpresa());

        // Guardar empresa per al 2n test
        this.empresa=empresaResult;
        // Crear 2a empresa -- No es comprova
        Empresa empresaACrear2 = new Empresa();
        empresaACrear2.setNomEmpresa("Accenture");
        empresaACrear2.setAdreca("Diagonal 504");
        empresaACrear2.setPoblacio("Barcelona");
        empresaACrear2.setSector("IT");
        empresaACrear2.setSocietat("SA");
        empresaACrear2.setNtreballadors(89L);

        HttpEntity<Empresa> entity2 = new HttpEntity<>(empresaACrear2);
        ResponseEntity<Empresa> result2 = testRestTemplate.exchange("http://localhost:8080/empresa", HttpMethod.POST,entity, Empresa.class);

    }

    @Test
    public void test2crearLlocTest() {
        //Crear llocs de treball a aquesta empresa (3 en 1a empresa)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        //Lloc 1
        Lloc llocACrear = new Lloc();
        llocACrear.setEmpresa(this.empresa);
        llocACrear.setNomLloc("Programador");

        HttpEntity<Lloc> entity = new HttpEntity<>(llocACrear);
        ResponseEntity<Lloc> result = testRestTemplate.exchange("http://localhost:8080/lloc", HttpMethod.POST,entity, Lloc.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Lloc llolcResult = result.getBody();
        Assert.assertEquals(llocACrear.getEmpresa().getIdEmpresa(),llolcResult.getEmpresa().getIdEmpresa());
        Assert.assertNotNull(llolcResult.getIdLloc());
        this.lloc1=llolcResult;

        //Lloc 2
        Lloc llocACrear2 = new Lloc();
        llocACrear2.setEmpresa(this.empresa);
        llocACrear2.setNomLloc("Dissenyador");

        entity = new HttpEntity<>(llocACrear2);
        ResponseEntity<Lloc> result2 = testRestTemplate.exchange("http://localhost:8080/lloc", HttpMethod.POST,entity, Lloc.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Lloc llolcResult2 = result2.getBody();
        Assert.assertEquals(llocACrear2.getEmpresa().getIdEmpresa(),llolcResult2.getEmpresa().getIdEmpresa());
        Assert.assertNotNull(llolcResult.getIdLloc());
        this.lloc2=llolcResult2;

        //Lloc3
        Lloc llocACrear3 = new Lloc();
        llocACrear3.setEmpresa(this.empresa);
        llocACrear3.setNomLloc("Marketing Assistant");

        entity = new HttpEntity<>(llocACrear3);
        ResponseEntity<Lloc> result3 = testRestTemplate.exchange("http://localhost:8080/lloc", HttpMethod.POST,entity, Lloc.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Lloc llolcResult3 = result3.getBody();
        Assert.assertEquals(llocACrear3.getEmpresa().getIdEmpresa(),llolcResult3.getEmpresa().getIdEmpresa());
        Assert.assertNotNull(llolcResult.getIdLloc());

    }

    @Test
    public void test3CrearOpinions(){
        //Crear opinions (3 del 1r lloc, 2 del 2n)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        //Lloc 1 Opinio 1
        Opinio OpinioACrear = new Opinio();
        OpinioACrear.setSubContratat(true);
        OpinioACrear.setQuantSalari(100.0);
        OpinioACrear.setPeriodeSalari("€/mes");
        OpinioACrear.setRecomanacio(3);
        OpinioACrear.setTipusContracte("Temporal");
        OpinioACrear.setDuracioMitjanaContractes("Meses");
        OpinioACrear.setAntiguitatMitjana(10.5);
        OpinioACrear.setFixe(true);
        OpinioACrear.setVacancesPagades(true);
        OpinioACrear.setCarregaFeina("Alta");
        OpinioACrear.setProporcio(60.0);
        OpinioACrear.setEdatMitjanaPlantilla(27.0);
        OpinioACrear.setGrauTreballEquip("Individual");
        OpinioACrear.setPros("Mola mucho");
        OpinioACrear.setContres("Mola poco");
        OpinioACrear.setLloc(this.lloc1);


        HttpEntity<Opinio> entity = new HttpEntity<>(OpinioACrear);
        ResponseEntity<Opinio> result = testRestTemplate.exchange("http://localhost:8080/opinio", HttpMethod.POST,entity, Opinio.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Opinio OpinioResult = result.getBody();
        Assert.assertEquals(OpinioACrear.getLloc().getIdLloc(),OpinioResult.getLloc().getIdLloc());
        Assert.assertNotNull(OpinioResult.getIdOpinio());

        this.opinio1=OpinioResult;


        //Lloc 1 Opinio 2
        Opinio OpinioACrear2 = new Opinio();
        OpinioACrear2.setSubContratat(false);
        OpinioACrear2.setQuantSalari(300.0);
        OpinioACrear2.setPeriodeSalari("€/mes");
        OpinioACrear2.setRecomanacio(5);
        OpinioACrear2.setTipusContracte("Indefinit");
        OpinioACrear2.setDuracioMitjanaContractes("Anys");
        OpinioACrear2.setAntiguitatMitjana(10.5);
        OpinioACrear2.setFixe(false);
        OpinioACrear2.setVacancesPagades(false);
        OpinioACrear2.setCarregaFeina("Baixa");
        OpinioACrear2.setProporcio(70.0);
        OpinioACrear2.setEdatMitjanaPlantilla(55.0);
        OpinioACrear2.setGrauTreballEquip("Individual");
        OpinioACrear2.setPros("Mola bastante");
        OpinioACrear2.setContres("Mola");
        OpinioACrear2.setLloc(this.lloc1);

        entity = new HttpEntity<>(OpinioACrear2);
        ResponseEntity<Opinio> result2 = testRestTemplate.exchange("http://localhost:8080/opinio", HttpMethod.POST, entity, Opinio.class);

        Assert.assertEquals(200,result2.getStatusCodeValue());
        Opinio OpinioResult2 = result2.getBody();
        Assert.assertEquals(OpinioACrear2.getLloc().getIdLloc(),OpinioResult2.getLloc().getIdLloc());
        Assert.assertNotNull(OpinioResult2.getIdOpinio());

        //Lloc 1 Opinio 3
        Opinio OpinioACrear3 = new Opinio();
        OpinioACrear3.setSubContratat(true);
        OpinioACrear3.setQuantSalari(10.0);
        OpinioACrear3.setPeriodeSalari("€/dia");
        OpinioACrear3.setRecomanacio(2);
        OpinioACrear3.setTipusContracte("Temporal");
        OpinioACrear3.setDuracioMitjanaContractes("Dies");
        OpinioACrear3.setAntiguitatMitjana(53.5);
        OpinioACrear3.setFixe(true);
        OpinioACrear3.setVacancesPagades(false);
        OpinioACrear3.setCarregaFeina("Alta");
        OpinioACrear3.setProporcio(10.0);
        OpinioACrear3.setEdatMitjanaPlantilla(60.0);
        OpinioACrear3.setGrauTreballEquip("Individual");
        OpinioACrear3.setPros("Mola");
        OpinioACrear3.setContres("aloM");
        OpinioACrear3.setLloc(this.lloc1);

        entity = new HttpEntity<>(OpinioACrear3);
        ResponseEntity<Opinio> result3 = testRestTemplate.exchange("http://localhost:8080/opinio", HttpMethod.POST, entity, Opinio.class);

        Assert.assertEquals(200,result3.getStatusCodeValue());
        Opinio OpinioResult3 = result3.getBody();
        Assert.assertEquals(OpinioACrear3.getLloc().getIdLloc(),OpinioResult3.getLloc().getIdLloc());
        Assert.assertNotNull(OpinioResult3.getIdOpinio());


        //Lloc 2 Opinio 1
        Opinio OpinioACrear4 = new Opinio();
        OpinioACrear4.setSubContratat(false);
        OpinioACrear4.setQuantSalari(300.0);
        OpinioACrear4.setPeriodeSalari("€/mes");
        OpinioACrear4.setRecomanacio(5);
        OpinioACrear4.setTipusContracte("Indefinit");
        OpinioACrear4.setDuracioMitjanaContractes("Anys");
        OpinioACrear4.setAntiguitatMitjana(10.5);
        OpinioACrear4.setFixe(false);
        OpinioACrear4.setVacancesPagades(false);
        OpinioACrear4.setCarregaFeina("Baixa");
        OpinioACrear4.setProporcio(70.0);
        OpinioACrear4.setEdatMitjanaPlantilla(55.0);
        OpinioACrear4.setGrauTreballEquip("Individual");
        OpinioACrear4.setPros("Mola bastante");
        OpinioACrear4.setContres("Mola");
        OpinioACrear4.setLloc(this.lloc2);

        entity = new HttpEntity<>(OpinioACrear4);
        ResponseEntity<Opinio> result4 = testRestTemplate.exchange("http://localhost:8080/opinio", HttpMethod.POST, entity, Opinio.class);

        Assert.assertEquals(200,result4.getStatusCodeValue());
        Opinio OpinioResult4 = result4.getBody();
        Assert.assertEquals(OpinioACrear4.getLloc().getIdLloc(),OpinioResult4.getLloc().getIdLloc());
        Assert.assertNotNull(OpinioResult4.getIdOpinio());


        //Lloc 2 Opinio 2
        Opinio OpinioACrear5 = new Opinio();
        OpinioACrear5.setSubContratat(false);
        OpinioACrear5.setQuantSalari(300.0);
        OpinioACrear5.setPeriodeSalari("€/mes");
        OpinioACrear5.setRecomanacio(5);
        OpinioACrear5.setTipusContracte("Indefinit");
        OpinioACrear5.setDuracioMitjanaContractes("Anys");
        OpinioACrear5.setAntiguitatMitjana(10.5);
        OpinioACrear5.setFixe(false);
        OpinioACrear5.setVacancesPagades(false);
        OpinioACrear5.setCarregaFeina("Baixa");
        OpinioACrear5.setProporcio(70.0);
        OpinioACrear5.setEdatMitjanaPlantilla(55.0);
        OpinioACrear5.setGrauTreballEquip("Individual");
        OpinioACrear5.setPros("Mola bastante");
        OpinioACrear5.setContres("Mola");
        OpinioACrear5.setLloc(this.lloc2);

        entity = new HttpEntity<>(OpinioACrear5);
        ResponseEntity<Opinio> result5 = testRestTemplate.exchange("http://localhost:8080/opinio", HttpMethod.POST, entity, Opinio.class);

        Assert.assertEquals(200,result5.getStatusCodeValue());
        Opinio OpinioResult5 = result5.getBody();
        Assert.assertEquals(OpinioACrear5.getLloc().getIdLloc(),OpinioResult5.getLloc().getIdLloc());
        Assert.assertNotNull(OpinioResult5.getIdOpinio());

    }

    @Test
    public void test4ObtenirDadesEmpresa(){
      //Obtenir dades empresa (comprovar que son les creades al pas 1)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        Empresa empresaAObtenir = this.empresa;

        HttpEntity<Empresa> entity = new HttpEntity<>(empresaAObtenir);
        ResponseEntity<Empresa> result = testRestTemplate.exchange("http://localhost:8080/empresa/"+empresaAObtenir.getIdEmpresa().toString(), HttpMethod.GET, entity, Empresa.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Empresa empresaResult = result.getBody();
        Assert.assertEquals(empresaAObtenir.getNomEmpresa(),empresaResult.getNomEmpresa());
        Assert.assertEquals(empresaAObtenir.getAdreca(),empresaResult.getAdreca());
        Assert.assertEquals(empresaAObtenir.getPoblacio(),empresaResult.getPoblacio());
        Assert.assertEquals(empresaAObtenir.getSector(),empresaResult.getSector());
        Assert.assertEquals(empresaAObtenir.getSocietat(),empresaResult.getSocietat());
        Assert.assertEquals(empresaAObtenir.getNtreballadors(),empresaResult.getNtreballadors());
        Assert.assertNotNull(empresaResult.getIdEmpresa());


    }

    @Test
    public void test5ObtenirLlistaLloc(){
        //Obtenir llista de llocs de treball ( (comprovar que son les creades al pas 2)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        //Lloc 1
        Lloc llocAObtenir = this.lloc1;

        HttpEntity<Lloc> entity = new HttpEntity<>(llocAObtenir);
        ResponseEntity<Lloc> result = testRestTemplate.exchange("http://localhost:8080/lloc/"+llocAObtenir.getIdLloc().toString(), HttpMethod.GET, entity, Lloc.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Lloc llocResult = result.getBody();
        Assert.assertEquals(llocAObtenir.getNomLloc(),llocResult.getNomLloc());

        Assert.assertNotNull(llocResult.getIdLloc());

        //Lloc 2
        Lloc llocAObtenir2 = this.lloc2;

        entity = new HttpEntity<>(llocAObtenir2);
        ResponseEntity<Lloc> result2 = testRestTemplate.exchange("http://localhost:8080/lloc/"+llocAObtenir2.getIdLloc().toString(), HttpMethod.GET, entity, Lloc.class);

        Assert.assertEquals(200,result2.getStatusCodeValue());
        Lloc llocResult2 = result2.getBody();
        Assert.assertEquals(llocAObtenir2.getNomLloc(),llocResult2.getNomLloc());

        Assert.assertNotNull(llocResult2.getIdLloc());


    }

    @Test
    public void test6LlistaOpinions(){
        //Obtenir llista d'opinions del lloc de treball (si hi ha paginació, provar-la) (comprovar que son les creades al pas 3) amb camps calculats correctes (valoració mitjana)

    }

    @Test
    public void test7ObtenirOpinio(){
        //Obtenir detall d'una opinió ( comprovar que quadra amb una creada al pas 3)
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        Opinio opinioAObtenir = this.opinio1;
        HttpEntity<Opinio> entity = new HttpEntity<>(opinioAObtenir);
        ResponseEntity<Opinio> result = testRestTemplate.exchange("http://localhost:8080/opinio/"+opinioAObtenir.getIdOpinio().toString(), HttpMethod.GET, entity, Opinio.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Opinio OpinioResult = result.getBody();
        Assert.assertEquals(opinioAObtenir.getIdOpinio(),OpinioResult.getIdOpinio());
        Assert.assertNotNull(OpinioResult.getIdOpinio());

    }

    @Test
    public void test8ModificarOpinio(){
        //Modificar opinió (comprovar després que al obtenir-la, obtenim els nous valors)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        Opinio opinioAObtenir = this.opinio1;


        Opinio opinioAModificar = this.opinio1;
        opinioAModificar.setSubContratat(false);
        opinioAModificar.setQuantSalari(300.0);
        opinioAModificar.setPeriodeSalari("€/mes");
        opinioAModificar.setRecomanacio(5);
        opinioAModificar.setTipusContracte("Indefinit");
        opinioAModificar.setDuracioMitjanaContractes("Anys");
        opinioAModificar.setAntiguitatMitjana(10.5);
        opinioAModificar.setFixe(false);
        opinioAModificar.setVacancesPagades(false);
        opinioAModificar.setCarregaFeina("Baixa");
        opinioAModificar.setProporcio(70.0);
        opinioAModificar.setEdatMitjanaPlantilla(55.0);
        opinioAModificar.setGrauTreballEquip("Individual");
        opinioAModificar.setPros("Mola bastante");
        opinioAModificar.setContres("Mola");



        HttpEntity<Opinio> entity = new HttpEntity<>(opinioAModificar);
        ResponseEntity<Opinio> result = testRestTemplate.exchange("http://localhost:8080/opinio", HttpMethod.PUT, entity, Opinio.class);

        Assert.assertEquals(200,result.getStatusCodeValue());
        Opinio opinioResult = result.getBody();
        Assert.assertNotEquals(opinioAObtenir.getSubContratat(),opinioResult.getSubContratat());
        Assert.assertNotEquals(opinioAObtenir.getQuantSalari(),opinioResult.getQuantSalari());
        Assert.assertNotEquals(opinioAObtenir.getPeriodeSalari(),opinioResult.getPeriodeSalari());
        Assert.assertNotEquals(opinioAObtenir.getRecomanacio(),opinioResult.getSubContratat());
        Assert.assertNotEquals(opinioAObtenir.getTipusContracte(),opinioResult.getTipusContracte());
        Assert.assertNotEquals(opinioAObtenir.getDuracioMitjanaContractes(),opinioResult.getDuracioMitjanaContractes());
        Assert.assertNotEquals(opinioAObtenir.getAntiguitatMitjana(),opinioResult.getAntiguitatMitjana());
        Assert.assertNotEquals(opinioAObtenir.getFixe(),opinioResult.getFixe());
        Assert.assertNotEquals(opinioAObtenir.getVacancesPagades(),opinioResult.getVacancesPagades());
        Assert.assertNotEquals(opinioAObtenir.getCarregaFeina(),opinioResult.getCarregaFeina());
        Assert.assertNotEquals(opinioAObtenir.getProporcio(),opinioResult.getProporcio());
        Assert.assertNotEquals(opinioAObtenir.getEdatMitjanaPlantilla(),opinioResult.getEdatMitjanaPlantilla());
        Assert.assertNotEquals(opinioAObtenir.getGrauTreballEquip(),opinioResult.getGrauTreballEquip());
        Assert.assertNotEquals(opinioAObtenir.getPros(),opinioResult.getPros());
        Assert.assertNotEquals(opinioAObtenir.getContres(),opinioResult.getContres());


    }

    @Test
    public void test9EsborrarOpinio(){
        //Esborrar opinió (comprovar que ja no apareix a la llista d'opinions)
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        Opinio opinioAObtenir = this.opinio1;
        HttpEntity<Opinio> entity = new HttpEntity<>(opinioAObtenir);
        ResponseEntity<Opinio> result = testRestTemplate.exchange("http://localhost:8080/opinio/"+opinioAObtenir.getIdOpinio().toString(), HttpMethod.DELETE, entity, Opinio.class);

        Assert.assertEquals(200,result.getStatusCodeValue());

        Assert.assertNull(result.getBody());

    }




}

