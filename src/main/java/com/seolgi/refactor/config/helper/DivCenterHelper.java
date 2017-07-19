package com.seolgi.refactor.config.helper;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class DivCenterHelper implements Helper<Object> {


    @Override
    public CharSequence apply(Object object, Options options) throws IOException {
        Integer current = (Integer) object + 1;
        Integer totalCount = options.get("totalCount");
        options.get("totalCount");
        if (current == 1) {
            if (totalCount == 1)
                return new Handlebars.SafeString("col-md-offset-4");
            else if (totalCount == 2)
                return new Handlebars.SafeString("col-md-offset-2");
            return new Handlebars.SafeString("");
        } else {
            return new Handlebars.SafeString("");
        }
    }
}


