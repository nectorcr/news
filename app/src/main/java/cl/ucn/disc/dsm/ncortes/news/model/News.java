/*
 * Copyright 2020. Nector Cortés Rojas, nector.cortes@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.ncortes.news.model;

import net.openhft.hashing.LongHashFunction;

import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.ncortes.news.utils.Validation;

/**
 * The domain model: News.
 *
 * @author Nector Cortés Rojas
 */
public final class News {

    /**
     * Unique id.
     */
    private final Long id;

    /**
     * The Title.
     * Restrictions: not null, size > 2
     */
    private final String title;

    /**
     * The Source.
     */
    private final String source;

    /**
     * The Author.
     */
    private final String author;

    /**
     * The URL.
     */
    private final String url;

    /**
     * The URL of image.
     */
    private final String urlImage;

    /**
     * The Description.
     */
    private final String description;

    /**
     * The Content.
     */
    private final String content;

    /**
     * The Date of publish.
     */
    private final ZonedDateTime publishedAt;

    /**
     * The Constructor.
     *
     * @param title
     * @param source
     * @param author
     * @param url
     * @param urlImage
     * @param description
     * @param content
     * @param publishedAt
     */
    public News(String title, String source, String author, String url, String urlImage, String description, String content, ZonedDateTime publishedAt) {

        // Validation of the title
        Validation.minSize(title, 2, "title");
        this.title = title;

        // Validation of the source
        Validation.minSize(source, 2, "source");
        this.source = source;

        // Validation of the author
        Validation.minSize(author, 2, "author");
        this.author = author;

        // Apply the xxHash function
        this.id = LongHashFunction.xx().hashChars(title + source + author);

        this.url = url;
        this.urlImage = urlImage;
        this.description = description;

        Validation.notNull(content, "content");
        this.content = content;

        Validation.notNull(publishedAt, "publishedAt");
        this.publishedAt = publishedAt;

    }

    /**
     * @return The id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return The Title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The Source.
     */
    public String getSource() {
        return source;
    }

    /**
     * @return The Author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return The URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return The URL of Image.
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @return The Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The Content.
     */
    public String getContent() {
        return content;
    }

    /**
     * @return The PublishedAt.
     */
    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }
}
