package regex_new.service;

import org.springframework.stereotype.Service;
import regex_new.entity.RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegExServiceImpl implements RegExService {

    @Override
    public String find(RegEx regularExpression, String text) {
        Pattern pattern = Pattern.compile(regularExpression.getRegularExpression());
        Matcher matcher = pattern.matcher(text);

        return matcher.group();
    }

    @Override
    public String replaceFirst(RegEx searchByRegEx, RegEx replaceByRegEx, String text) {
        return text.replaceFirst(searchByRegEx.getRegularExpression(), replaceByRegEx.getRegularExpression());
    }

    @Override
    public String replaceAll(RegEx searchByRegEx, RegEx replaceByRegEx, String text) {
        return text.replaceAll(searchByRegEx.getRegularExpression(), replaceByRegEx.getRegularExpression());
    }
}
