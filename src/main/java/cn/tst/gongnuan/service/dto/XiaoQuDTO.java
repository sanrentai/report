/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * 小区
 *
 * @author CaoChun
 */
@Entity
public class XiaoQuDTO implements Serializable {
    @Id
    private String id;

    private String name;

    public XiaoQuDTO() {
    }

    public XiaoQuDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
