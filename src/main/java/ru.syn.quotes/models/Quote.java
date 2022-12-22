package ru.syn.quotes.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "\"Quotes2\"")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "text", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String text;

    @Column(name = "\"quoteId\"", nullable = false)
    private Integer quoteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

}