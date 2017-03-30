package com.ociweb.quickcasts

class QuickcastController {
    static responseFormats = ['xml']

    def relatedQuickcastsService

    def index() {
        [quickcasts: Quickcast.quickcastList()]
    }

    def show(Long id) {
        def quickcast = Quickcast.quickcastList().find { it.id ==  id}
        def relatedQuickcasts = relatedQuickcastsService.findAllRelatedQuickcasts(quickcast)
        [quickcast: quickcast, relatedQuickcasts: relatedQuickcasts]
    }
}
