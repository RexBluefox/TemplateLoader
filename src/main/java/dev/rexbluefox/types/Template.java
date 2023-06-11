package dev.rexbluefox.types;

import org.bukkit.block.Block;

import java.util.ArrayList;

public class Template {
    private String name;
    private ArrayList<Block> template;

    public Template(String name, ArrayList<Block> template){
        this.name = name;
        this.template = template;
    }
    public Template(String name){
        this.name = name;
    }


    public ArrayList<Block> getTemplate() {
        return template;
    }

    public String getName() {
        return name;
    }

    public void setTemplate(ArrayList<Block> template) {
        this.template = template;
    }

    public void setName(String name) {
        this.name = name;
    }
}
