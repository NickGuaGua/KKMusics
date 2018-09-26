package com.guagua.kkmusics

import com.guagua.kkmusics.model.domainObject.NewHitsPlaylist
import com.guagua.kkmusics.model.musicModel.MusicsDataSource
import com.guagua.kkmusics.model.musicModel.MusicsRepository
import com.guagua.kkmusics.newHitsPlaylist.NewHitsPlaylistContract
import com.guagua.kkmusics.newHitsPlaylist.NewHitsPlaylistPresenter
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NewHitsPlaylistTest{

    @Mock
    private lateinit var musicsRepository: MusicsRepository

    @Mock
    private lateinit var view: NewHitsPlaylistContract.View

    private lateinit var presenter: NewHitsPlaylistContract.Presenter

    private val newHitsPlaylist = NewHitsPlaylist()

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = NewHitsPlaylistPresenter(musicsRepository)
        presenter.setView(view)
    }

    @Test
    fun flowTest(){

        presenter.getPlaylistDataFromIntent()
        verify(view).getPlaylistDataFromIntent()

        presenter.initTitleBar()
        verify(view).initTitleBar()

        presenter.initNewHitsPlaylist()
        verify(view).initNewHitsPlaylist()

        presenter.getNewHitsPlaylist("DZrC8m29ciOFY2JAm3")
        argumentCaptor<MusicsDataSource.GetNewHitsPlaylistCallback>().apply{
            verify(musicsRepository).getNewHitsPlaylist(eq("DZrC8m29ciOFY2JAm3"), capture())
            lastValue.onDataReturn(newHitsPlaylist)
            verify(view).setNewHitsPlaylist(newHitsPlaylist)
        }

        presenter.initBanner()
        verify(view).initBanner()

    }

}