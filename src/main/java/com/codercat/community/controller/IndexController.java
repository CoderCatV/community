package com.codercat.community.controller;

import com.codercat.community.mapper.QuestionMapper;
import com.codercat.community.mapper.UserMapper;
import com.codercat.community.model.Question;
import com.codercat.community.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/13
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private QuestionMapper questionMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = userMapper.findUserByToken(token);
                    if (user != null) {
                        System.out.println(user.getName());
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<Question> questionList = questionMapper.list();
        model.addAttribute("questionList",questionList);
        return "index";
    }
}
