package net.helg40k.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by helg40k on 9/22/15.
 */
@Controller
@RequestMapping
public class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/children", method = RequestMethod.GET)
    public @ResponseBody List<String> welcomeName() {

        File file = new File(".");
        File[] children = file.listFiles();
        List<String> fileNames = null;
        if (null != children) {
            fileNames = new ArrayList<>(children.length);
            for (File child : children) {
                fileNames.add(child.getAbsolutePath());
            }
        }

        return fileNames;
    }

}
