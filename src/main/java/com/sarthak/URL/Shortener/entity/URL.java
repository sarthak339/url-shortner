package com.sarthak.URL.Shortener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "url")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class URL {

    @Id
    @Column(name = "short_url",nullable = false)
    private String shortenedURL;

    @Column(name = "full_url",nullable = false,unique = true)
    private String fullURL;

    @Column(nullable = false)
    private Date date;

}
