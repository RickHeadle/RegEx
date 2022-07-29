package regex_new.service;

import regex_new.entity.RegEx;

public interface RegExService {

    String find(RegEx regularExpression, String text);
    String replaceFirst(RegEx searchByRegEx, RegEx replaceByRegEx, String text);
    String replaceAll(RegEx searchByRegEx, RegEx replaceByRegEx, String text);
}