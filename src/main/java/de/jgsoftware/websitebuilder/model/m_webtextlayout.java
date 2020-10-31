package de.jgsoftware.websitebuilder.model;


import javax.persistence.*;


@Entity
@Table(name = "webtextlayout")
public class m_webtextlayout
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String framename;

    private String de;

    private String eng;

    private String fr;

    private String esp;

    private String it;

    private String tr;

    private String bindto;

    private String template;

    private String titletemplate;

    private String comp_name;


    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFramename() {
        return framename;
    }

    public void setFramename(String framename) {
        this.framename = framename;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getBindto() {
        return bindto;
    }

    public void setBindto(String bindto) {
        this.bindto = bindto;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTitletemplate() {
        return titletemplate;
    }

    public void setTitletemplate(String titletemplate) {
        this.titletemplate = titletemplate;
    }
}
