package com.example.philippnoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.philippnoteapp.data.data_source.NoteDatabase
import com.example.philippnoteapp.data.repository.NoteRepositoryImpl
import com.example.philippnoteapp.domain.repository.NoteRepository
import com.example.philippnoteapp.domain.use_case.AddNote
import com.example.philippnoteapp.domain.use_case.DeleteNote
import com.example.philippnoteapp.domain.use_case.GetNote
import com.example.philippnoteapp.domain.use_case.GetNotes
import com.example.philippnoteapp.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}