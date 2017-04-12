package com.litrum.webproject.controller;

import com.litrum.webproject.model.EndUserRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Vishal on 4/8/2017.
 */

@Controller
public class EditorController {

    private static Logger logger = LoggerFactory.getLogger(EditorController.class);

    @RequestMapping(value = "/editorPannelHome", method = RequestMethod.GET)
    public String editorDashboard(Model uiModel) {

        logger.debug(" editorPannelHome : GET ");
        return "editorviews/editorPannelHome";
    }

    @RequestMapping(value = "/editorPannelMainItemAdd", method = RequestMethod.GET)
    public String editorPannelMainItemGet(Model uiModel) {

        logger.debug(" editorPannelMainItemAdd : GET ");
        return "editorviews/editorPannelMainItemAdd";
    }
}
