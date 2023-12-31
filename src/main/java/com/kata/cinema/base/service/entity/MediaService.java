package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.Media;

public interface MediaService {
    Media getMedia(Long id);

    void createMedia(Media media);

    void updateMedia(Long id, Media media);

    void changeEnableStatus(Long id);

    void changeStatusWaitVerify(Long id);

    void delete(Long id);

    void publish(Long id);

    Media getMediaById(Long id);
}
