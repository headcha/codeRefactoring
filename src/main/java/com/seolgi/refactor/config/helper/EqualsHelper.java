package com.seolgi.refactor.config.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.util.Objects;

public class EqualsHelper implements Helper<Object> {
    @Override
    public CharSequence apply(Object object, Options options) throws IOException {
        Object obj2 = options.param(0);
        return Objects.equals(object, obj2) ? options.fn() : options.inverse();
    }
}
