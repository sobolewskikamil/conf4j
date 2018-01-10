/*
 * MIT License
 *
 * Copyright 2017 Sabre GLBL Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.sabre.oss.conf4j.factory.javassist;

import com.sabre.oss.conf4j.factory.AbstractStaticConfigurationFactoryTest;
import com.sabre.oss.conf4j.factory.model.ValidAbstractConfigurationImpl;
import org.junit.jupiter.api.Test;

import static com.sabre.oss.conf4j.source.OptionalValue.absent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class JavassistStaticConfigurationFactoryTest extends AbstractStaticConfigurationFactoryTest<JavassistStaticConfigurationFactory> {
    @Override
    protected JavassistStaticConfigurationFactory createConfigurationFactory() {
        return new JavassistStaticConfigurationFactory();
    }

    @Test
    public void shouldAllowToBuildConfigurationWithImplementedMethods() {
        // when
        when(source.getValue(anyString(), any())).thenReturn(absent());

        ValidAbstractConfigurationImpl configInstance = factory.createConfiguration(ValidAbstractConfigurationImpl.class, source);
        // then
        assertThat(configInstance.getIntegerProperty()).isEqualTo(123);
        assertThat(configInstance.getImplementedProperty()).isEqualTo("value from non abstract method");
    }
}
