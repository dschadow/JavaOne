package de.bit.camel.security;

public class TestResults {
    public static final String COMPLETE_RESULT_ALICE = new StringBuilder()
            .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><employee>\n").append("    <department/>\n")
            .append("    <empId>10001</empId>\n").append("    <entryDate>01.01.2008</entryDate>\n")
            .append("    <jobTitle>Manager</jobTitle>\n").append("    <name>Alice</name>\n")
            .append("    <salary>10000</salary>\n").append("    <total>8700</total>\n").append("</employee>")
            .toString();

    public static final String COMPLETE_RESULT_BOB = new StringBuilder()
            .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><employee>\n")
            .append("    <department>IT</department>\n").append("    <empId>10002</empId>\n")
            .append("    <entryDate>01.06.2005</entryDate>\n").append("    <jobTitle>Administrator</jobTitle>\n")
            .append("    <name>Bob</name>\n").append("    <salary>5000</salary>\n").append("    <total>0</total>\n")
            .append("</employee>").toString();
}
