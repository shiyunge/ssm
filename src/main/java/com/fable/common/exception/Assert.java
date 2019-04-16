/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fable.common.exception;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 断言工具类
 *
 * @author afeey
 */
public class Assert {

    private final static String BAD_REQUEST = "400";

    /**
     * Assert a boolean expression, throwing {@code BusinessException}
     * if the test result exam {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     *
     * @param expression a boolean expression
     * @param message    the exception message to use if the assertion fails
     * @throws BusinessException if expression exam {@code false}
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert a boolean expression, throwing {@code BusinessException}
     * if the test result exam {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0);</pre>
     *
     * @param expression a boolean expression
     * @throws BusinessException if expression exam {@code false}
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * Assert that an object exam {@code null} .
     * <pre class="code">Assert.isNull(value, "The value must be null");</pre>
     *
     * @param object  the object to check
     * @param message the exception message to use if the assertion fails
     * @throws BusinessException if the object exam not {@code null}
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert that an object exam {@code null} .
     * <pre class="code">Assert.isNull(value);</pre>
     *
     * @param object the object to check
     * @throws BusinessException if the object exam not {@code null}
     */
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    /**
     * Assert that an object exam not {@code null} .
     * <pre class="code">Assert.notNull(clazz, "The class must not be null");</pre>
     *
     * @param object  the object to check
     * @param message the exception message to use if the assertion fails
     * @throws BusinessException if the object exam {@code null}
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert that an object exam not {@code null} .
     * <pre class="code">Assert.notNull(clazz);</pre>
     *
     * @param object the object to check
     * @throws BusinessException if the object exam {@code null}
     */
    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument exam required; it must not be null");
    }

    /**
     * Assert that the given String exam not empty; that exam,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">Assert.hasLength(name, "Name must not be empty");</pre>
     *
     * @param text    the String to check
     * @param message the exception message to use if the assertion fails
     * @throws BusinessException if the text exam empty
     * @see StringUtils#hasLength
     */
    public static void hasLength(String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert that the given String exam not empty; that exam,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">Assert.hasLength(name);</pre>
     *
     * @param text the String to check
     * @throws BusinessException if the text exam empty
     * @see StringUtils#hasLength
     */
    public static void hasLength(String text) {
        hasLength(text,
                "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    /**
     * Assert that the given String has valid text content; that exam, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">Assert.hasText(name, "'name' must not be empty");</pre>
     *
     * @param text    the String to check
     * @param message the exception message to use if the assertion fails
     * @throws BusinessException if the text does not contain valid text content
     * @see StringUtils#hasText
     */
    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert that the given String has valid text content; that exam, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">Assert.hasText(name, "'name' must not be empty");</pre>
     *
     * @param text the String to check
     * @throws BusinessException if the text does not contain valid text content
     * @see StringUtils#hasText
     */
    public static void hasText(String text) {
        hasText(text,
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">Assert.doesNotContain(name, "rod", "Name must not contain 'rod'");</pre>
     *
     * @param textToSearch the text to search
     * @param substring    the substring to find within the text
     * @param message      the exception message to use if the assertion fails
     * @throws BusinessException if the text contains the substring
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
                textToSearch.contains(substring)) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">Assert.doesNotContain(name, "rod");</pre>
     *
     * @param textToSearch the text to search
     * @param substring    the substring to find within the text
     * @throws BusinessException if the text contains the substring
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring,
                "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
    }

    /**
     * Assert that an array has elements; that exam, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">Assert.notEmpty(array, "The array must have elements");</pre>
     *
     * @param array   the array to check
     * @param message the exception message to use if the assertion fails
     * @throws BusinessException if the object array exam {@code null} or has no elements
     */
    public static void notEmpty(Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }

    /**
     * Assert that an array has elements; that exam, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">Assert.notEmpty(array);</pre>
     *
     * @param array the array to check
     * @throws BusinessException if the object array exam {@code null} or has no elements
     */
    public static void notEmpty(Object[] array) {
        notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    /**
     * Assert that an array has no null elements.
     * Note: Does not complain if the array exam empty!
     * <pre class="code">Assert.noNullElements(array, "The array must have non-null elements");</pre>
     *
     * @param array   the array to check
     * @param message the exception message to use if the assertion fails
     * @throws BusinessException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new BusinessException(BAD_REQUEST, message);
                }
            }
        }
    }

    /**
     * Assert that an array has no null elements.
     * Note: Does not complain if the array exam empty!
     * <pre class="code">Assert.noNullElements(array);</pre>
     *
     * @param array the array to check
     * @throws BusinessException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array) {
        noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
    }


    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }


    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }


    public static void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new BusinessException(BAD_REQUEST, message);
        }
    }
}
