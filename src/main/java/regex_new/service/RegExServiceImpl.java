package regex_new.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import regex_new.entity.RegEx;
import regex_new.repository.RegExRepository;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegExServiceImpl implements RegExService {

    @Autowired
    private RegExRepository regExRepository;

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

    public Page<RegEx> findAll(Specification<RegEx> specification, Pageable pageable) {
        return regExRepository.findAll(specification, pageable);
    }

    public Optional<RegEx> findById(Long id) {
        return regExRepository.findById(id);
    }

    public RegEx save(RegEx regEx) {
        return regExRepository.save(regEx);
    }

    public Long deleteById(Long id) {
        regExRepository.deleteById(id);
        return id;
    }

    public Long deleteByEntity(RegEx regEx) {
        regExRepository.delete(regEx);
        return regEx.getId();
    }
}
