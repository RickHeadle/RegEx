package regex_new.service;

import regex_new.entity.RegEx;

public interface RegExService {

    public String find(RegEx regularExpression, String text);

    public String replaceFirst(RegEx searchByRegEx, RegEx replaceByRegEx, String text);

    public String replaceAll(RegEx searchByRegEx, RegEx replaceByRegEx, String text);
}