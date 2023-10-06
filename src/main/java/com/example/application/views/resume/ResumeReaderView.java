package com.example.application.views.resume;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.ai.formfiller.FormFiller;
import com.vaadin.flow.ai.formfiller.FormFillerResult;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Resume")
@Route(value = "")
@Uses(Icon.class)
public class ResumeReaderView extends Composite<VerticalLayout> {

    private H1 mainHeader = new H1();

    private TextField firstName = new TextField();

    private TextField lastName = new TextField();

    private H6 contactHeader = new H6();

    private TextField email = new TextField();

    private TextField phone = new TextField();

    private TextArea address = new TextArea();

    private H6 expHeader = new H6();

    private Grid<Experience> workExperience = new Grid<>(Experience.class);

    private Grid<Certification> certifications = new Grid<>(Certification.class);

    private H6 certHeader = new H6();

    private H6 skillsHeader = new H6();

    private Checkbox skillJava = new Checkbox();

    private Checkbox skillJavascript = new Checkbox();

    private Checkbox skillHTML = new Checkbox();

    private Checkbox skillCSS = new Checkbox();

    private Checkbox skillLit = new Checkbox();

    private Checkbox skillReact = new Checkbox();

    private Checkbox skillVaadin = new Checkbox();

    private Checkbox skillFigma = new Checkbox();

    private Checkbox skillHubspot = new Checkbox();

    private Checkbox skillSEO = new Checkbox();

    private Checkbox skillProjectManagement = new Checkbox();

    private H6 impressionHeader = new H6();

    private TextArea impression = new TextArea();

    private FormLayout fieldLayout = new FormLayout();

    public ResumeReaderView() {
        // Because of how this was auto-generated with AI, it might not be inte the way you're used to..

        // First we configure all the components
        getContent().setWidthFull();
        getContent().setMargin(false);
        getContent().setPadding(false);
        fieldLayout.getElement().getStyle().set("padding", "var(--lumo-space-m)");

        mainHeader.setText("Resume");
        mainHeader.getElement().getStyle().set("padding-left", "var(--lumo-space-m)");
        firstName.setLabel("First name");
        firstName.setId("firstName");
        lastName.setLabel("Last name");
        lastName.setId("lastName");

        contactHeader.setText("Contact details");
        contactHeader.getElement().getStyle().set("padding", "var(--lumo-space-l) 0 var(--lumo-space-s) 0");
        email.setLabel("Email");
        email.setId("email");
        phone.setLabel("Phone");
        phone.setId("phone");
        address.setLabel("Address");
        address.setId("address");

        expHeader.setText("Work experience");
        expHeader.getElement().getStyle().set("padding", "var(--lumo-space-l) 0 var(--lumo-space-s) 0");
        workExperience.setId("workExperience");
        workExperience.removeAllColumns();
        workExperience.addColumn(Experience::getPosition).setHeader("Position").setKey("position").setId("position");
        workExperience.addColumn(Experience::getCompany).setHeader("Company").setKey("company").setId("company");
        workExperience.addColumn(Experience::getStart).setHeader("From").setKey("start").setId("start");
        workExperience.addColumn(Experience::getEnd).setHeader("To").setKey("end").setId("end");
        workExperience.setAllRowsVisible(true);

        certHeader.setText("Certifications");
        certHeader.getElement().getStyle().set("padding", "var(--lumo-space-l) 0 var(--lumo-space-s) 0");
        certifications.setId("certifications");
        certifications.removeAllColumns();
        certifications.addColumn(Certification::getCertification).setHeader("Certification").setKey("certification").setId("certification");
        certifications.setAllRowsVisible(true);

        skillsHeader.setText("Skills");
        skillsHeader.getElement().getStyle().set("padding", "var(--lumo-space-l) 0 var(--lumo-space-s) 0");
        skillJava.setLabel("Java");
        skillJava.setId("skillJava");
        skillJavascript.setLabel("JavaScript");
        skillJavascript.setId("skillJavascript");
        skillHTML.setLabel("HTML");
        skillHTML.setId("skillHTML");
        skillCSS.setLabel("CSS");
        skillCSS.setId("skillCSS");
        skillLit.setLabel("Lit");
        skillLit.setId("skillLit");
        skillReact.setLabel("React");
        skillReact.setId("skillReact");
        skillVaadin.setLabel("Vaadin");
        skillVaadin.setId("skillVaadin");
        skillFigma.setLabel("Figma");
        skillFigma.setId("skillFigma");
        skillHubspot.setLabel("HubSpot");
        skillHubspot.setId("skillHubspot");
        skillSEO.setLabel("SEO");
        skillSEO.setId("skillSEO");
        skillProjectManagement.setLabel("Project management");
        skillProjectManagement.setId("skillProjectManagement");

        impressionHeader.setText("Impression");
        impressionHeader.getElement().getStyle().set("padding", "var(--lumo-space-l) 0 var(--lumo-space-s) 0");
        impression.setLabel("Overall impression (AI generated)");
        impression.setId("impression");

        // Now let's add stuff to the layout

        // First the application controls

        HorizontalLayout controls = new HorizontalLayout();
        controls.setWidthFull();
        controls.setMargin(false);
        controls.setPadding(true);
        controls.setSpacing(true);
        controls.setAlignItems(Alignment.END);
        controls.getElement().getThemeList().add("dark");
        getContent().add(controls);

        TextArea resumeText = new TextArea();
        resumeText.setPlaceholder("Paste CV here");
        resumeText.setWidthFull();
        resumeText.setHeight("100px");
        controls.add(resumeText);

        TextField assessFor = new TextField("Assess for");
        assessFor.setValue("Senior Java Developer");
        controls.add(assessFor);

        Button fillButton = new Button("Fill");
        controls.add(fillButton);

        // This is where the interesting stuff happens
        fillButton.addClickListener(event -> {

            // We'll use the assessFor field to determine what the AI should focus on in the impression
            String assessHint = (assessFor.getValue() == null || assessFor.getValue().isEmpty())
                                            ? "Give an impression how well this resume is written and the author's skills, summarizing strengths and weaknesses"
                                            : "Give an impression how well this resume suits a " + assessFor.getValue() + " position, with a strong focus on skill match, summarizing strengths and weaknesses";
            
            // We'll use the fieldInstructions to give the AI some hints on how to fill specific fields
            HashMap<Component,String> fieldInstructions = new HashMap<>(
                            Map.of(
                                    email,
                                    "Format as valid email, removing spaces and other illegal characters. Do not guess anything",
                                    impression,
                                    assessHint,
                                    workExperience, "List of work experiences, past and present.",
                                    certifications, "List of certifications."));

            // We'll use the contextInstructions to give the AI some generic hints on how to fill the form
            ArrayList<String> contextInstructions = new ArrayList<String>(
                            Arrays.asList("You are reading a Resume and creating a structured JSON from the content, including an impression of the author"));

            FormFiller filler = new FormFiller(fieldLayout,
                    fieldInstructions,
                    contextInstructions);

            FormFillerResult result = filler.fill(resumeText.getValue());

            // Print the request/response to the console for demo/debug purposes
            System.err.println("Request: " + result.getRequest());
            System.err.println("Response: " + result.getResponse());
        });

        // Then the actual resume form that we'll use FormFiller to fill
        getContent().add(mainHeader);
        getContent().add(fieldLayout);
        fieldLayout.add(firstName);
        fieldLayout.add(lastName);
        fieldLayout.add(contactHeader);
        fieldLayout.setColspan(contactHeader, 2);
        fieldLayout.add(email);
        fieldLayout.add(phone);
        fieldLayout.add(address);
        fieldLayout.setColspan(address, 2);
        fieldLayout.add(expHeader);
        fieldLayout.setColspan(expHeader, 2);
        fieldLayout.add(workExperience);
        fieldLayout.setColspan(workExperience, 2);
        fieldLayout.add(certHeader);
        fieldLayout.setColspan(certHeader, 2);
        fieldLayout.add(certifications);
        fieldLayout.setColspan(certifications, 2);
        fieldLayout.add(skillsHeader);
        fieldLayout.setColspan(skillsHeader, 2);
        fieldLayout.add(skillJava);
        fieldLayout.add(skillJavascript);
        fieldLayout.add(skillHTML);
        fieldLayout.add(skillCSS);
        fieldLayout.add(skillLit);
        fieldLayout.add(skillReact);
        fieldLayout.add(skillVaadin);
        fieldLayout.add(skillFigma);
        fieldLayout.add(skillHubspot);
        fieldLayout.add(skillSEO);
        fieldLayout.add(skillProjectManagement);
        fieldLayout.add(impressionHeader);
        fieldLayout.setColspan(impressionHeader, 2);
        fieldLayout.add(impression);
        fieldLayout.setColspan(impression, 2);
    }

    public static class Experience {
        private String position;
        private String company;
        private LocalDate start;
        private LocalDate end;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public LocalDate getStart() {
            return start;
        }

        public void setStart(LocalDate start) {
            this.start = start;
        }

        public LocalDate getEnd() {
            return end;
        }

        public void setEnd(LocalDate end) {
            this.end = end;
        }

    }

    public static class Certification {
        private String certification;

        public String getCertification() {
            return certification;
        }

        public void setCertification(String certification) {
            this.certification = certification;
        }

    }
}
