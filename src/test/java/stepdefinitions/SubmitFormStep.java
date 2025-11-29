package stepdefinitions;

import base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SubmitFormPage;

/**
 * Classe de test pour la soumission du formulaire Selenium
 */
public class SubmitFormStep extends TestBase {

    @Test
    public void testSubmitFormSuccess() {
        // Création de l'instance de la page du formulaire
        SubmitFormPage formPage = new SubmitFormPage(driver);

        // Ouvrir la page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Remplir les champs
        formPage.enterText("Tester");
        formPage.enterPassword("123456");

        // Vérifier que le champ désactivé est bien désactivé
        Assertions.assertFalse(formPage.isDisabledInputEnabled(),
                " Le champ désactivé ne devrait pas être activé !");

        // Sélectionner une option
        formPage.selectOption("2");

        // Soumettre le formulaire
        formPage.submitForm();

        // Vérifier le titre exact de la page cible
        String title = driver.getTitle();
        Assertions.assertEquals("Web form - target page", title,
                " Le titre de la page après soumission n’est pas celui attendu !");

        // Logs console
        System.out.println(" Formulaire soumis avec succès !");
        System.out.println(" Titre de la page après soumission : " + title);
    }
}
