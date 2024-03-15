/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crudhbn8.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
//    @Column(name = "last_name")
    private String hobby;
    @OneToOne(mappedBy="instructorDetail", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private Instructor instructor;

    public InstructorDetail(){}
    
    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    public Instructor getInstructor(){
        return instructor;
    }
    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
    }
    @Override
    public String toString() {
        return "InstructorDetail{" + "id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + '}';
    }
    
}
