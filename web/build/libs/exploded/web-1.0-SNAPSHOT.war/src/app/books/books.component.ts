import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  books: any;

  constructor(
    private bookService: BookService
  ) { }

  getBooks(): void {
    this.bookService.getBooks()
      .subscribe(books => {
        this.books = books['books'];
        // console.log(this.books);
      });
  }

  ngOnInit() {
    this.getBooks();
  }

}
