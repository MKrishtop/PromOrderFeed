package com.mikhailkrishtop.promorderfeed.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mykhailo on 4/11/15.
 */
@Root(name="item")
public class OrderItem {

    @Attribute(name="id", required=true)
    public int id;
    @Element(name="name", required=true)
    public String name;

}
