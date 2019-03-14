package JATest;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobAdvisorTest {

    private static Empresa empresa;

    @Test
    public void test1crearEmpresaTest() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        Empresa empresaACrear = new Empresa();
        empresaACrear.setNom("Empresa de Test");
        empresaACrear.setAdreca("Pau Claris 118");
        empresaACrear.setPoblacio("Barcelona");
        empresaACrear.setSector("IT");
        empresaACrear.setSocietat("SL");
        empresaACrear.setNum_treballadors(89);


        HttpEntity<Empresa> entity = new HttpEntity<>(empresaACrear);
        ResponseEntity<Empresa> result = testRestTemplate.exchange("http://localhost:8080/empresa", HttpMethod.POST,entity, Empresa.class);


        Assert.assertEquals(200,result.getStatusCodeValue());
        Empresa empresaResult = result.getBody();
        Assert.assertEquals(empresaACrear.getNom(),empresaResult.getNom());
        Assert.assertNotNull(empresaResult.getId());

        // Guardar empresa per al 2n test
        this.empresa=empresaResult;
        // Crear 2a empresa -- No es comprova
        Empresa empresaACrear2 = new Empresa();
        empresaACrear2.setNom("Accenture");
        empresaACrear2.setAdreca("Diagonal 504");
        empresaACrear2.setPoblacio("Barcelona");
        empresaACrear2.setSector("IT");
        empresaACrear2.setSocietat("SA");
        empresaACrear2.setNum_treballadors(89);

        HttpEntity<Empresa> entity2 = new HttpEntity<>(empresaACrear2);
        ResponseEntity<Empresa> result2 = testRestTemplate.exchange("http://localhost:8080/empresa", HttpMethod.POST,entity, Empresa.class);

    }

    @Test
    public void test2crearLlocTest() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();


        Lloc llocACrear = new Lloc();
        llocACrear.setEmpresa(this.empresa);
        llocACrear.setNom("Programador");

        HttpEntity<Lloc> entity = new HttpEntity<>(llocACrear);
        ResponseEntity<Lloc> result = testRestTemplate.exchange("http://localhost:8080/lloc", HttpMethod.POST,entity, Lloc.class);


        Assert.assertEquals(200,result.getStatusCodeValue());
        Lloc llolcResult = result.getBody();
        Assert.assertEquals(llocACrear.getNom(),llolcResult.getNom());
        Assert.assertNotNull(llolcResult.getId());

        // Crear 2a lloc -- No es comprova
        Lloc llocACrear2 = new Lloc();
        llocACrear2.setEmpresa(this.empresa);
        llocACrear2.setNom("Dissenyador");

        HttpEntity<Lloc> entity2 = new HttpEntity<>(llocACrear2);
        ResponseEntity<Lloc> result2 = testRestTemplate.exchange("http://localhost:8080/lloc", HttpMethod.POST,entity, Lloc.class);

        // Crear 3r lloc -- No es comprova
        Lloc llocACrear3 = new Lloc();
        llocACrear3.setEmpresa(this.empresa);
        llocACrear3.setNom("Marketing Assistant");

        HttpEntity<Lloc> entity3 = new HttpEntity<>(llocACrear3);
        ResponseEntity<Lloc> result3 = testRestTemplate.exchange("http://localhost:8080/lloc", HttpMethod.POST,entity, Lloc.class);

    }




}

