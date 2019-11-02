<h1 align="center">Enso Documentation Parser</h1>

This is a standalone edition of Enso Documentation Parser and HTML Generator.
For Enso language which contains even more advancd version of Doc Parser please visit [luna/enso](https://github.com/luna/enso) repository

This is the most advanced "Markdown-ish" tool on the market, with highest performance of 7.3 mln characters parsed per second

## How to run it?

1. Install sbt
2. clone this repo and launch in it sbt
3. go to project by typing `project syntax`
4. `run`

What you'll receive is html file generated from exaple.

To create your own page simply edit "inp" in `Main.scala` file.

## TODO
- To be further simplified and more user-friendly
- No need to change projects
- Take data from outer file or create Front-end app for parser (Scala + JS?)


# Enso Documentation Parser Reference
The Doc Parser is a really powerful tool, so even if user will make a mistake, it can still try to assign 
those elements properly, but will show that something seems wrorng with red color in generated file.
Doc Parser is also indent sensitive, so every wrong indentation, for example in lists will be renedered as you
have written, but with invalid annotation, in other places, every indentation from base is expected to be multiline code block.

### Tags
Starting from the top of the file, you can add tags.
There are 5 available tags : 
- DEPRECATED
- MODIFIED
- ADDED
- UPCOMING
- REMOVED

But if you make a mistake or type in unknown tag, parser will still run fine, producing
undefined tag called just like you've called it, ex. ALAMAKOTA

Furthermore you can add details to each tag by writing them right after tag declaration
with one space.

So if you want to declare tags, simply write them in uppercase on top of the file, before parser begins creation 
of other sections.

### Sections
Every time you create 2 newlines, parser will start a new text section and close the previous one. 
The first segment you'll write will go to the `Synopsis` part of the document, rest will be in the `Body`.
Synopsis is there to write a small note for coder about what this function/library etc. does, body is to 
provide details.
There are 5 possible types of sections in Doc Parser:
 - Raw - which is just a text block
 - Important - To provide important details about functionality, known errors etc.
 - Info - Just what name suggests
 - Example - Placement for your usage examples, great place to add inline/multiline code 

And this is how you invoke them
 - Raw - created automatically after two newlines
 - Important - Just add `!` before the section title
 - Info - Just add `?` before the section title
 - Example - Just add `>` before the section title

### Section titles
When you want to add title to Raw section, just add before raw one more newline, that is, instead of normal double-newline to end
section and start a new, use triple-newline
In other sections first line (until newline) is parsed as a section title.

### Links
There are two kinds of links:
- normal URL's - Created with this syntax : `[Link name](URL)`
- Image links - Created with this syntax : `![Image name](URL)`
Images are rendered in generated document, as expected, the inline url will look just as you expect - Link name inline with rest 
of the text, and on click will get you to expected page.

### Lists
There are two kinds of lists:
- unordered - created by text indentation of 2 spaces with `-` marker
- ordered - created by text indentation of 2 spaces with `*` marker
You can also nest lists one in another, just by adding 2-char indent with list marker in next line

### Inline & Multiline code
To create inline code just enclose it in `` ` ``
To create multiline code just make an indentation from base indent of current section

### Text formatters
Doc Parser currently supports 3 text formatters
- Italic - created by enclosing text with `_` mark, ex `_Foo_`
- Bold - created by enclosing text with `*` mark, ex `*Foo*`
- Strikeout - created by enclosing text with `~` mark, ex `~Foo~`
You can also combine those formatters. For user-friendliness, you can choose how you close your text, either in HTML-Style, that is `_*~Foo~*_` or totally scrambled. But if you wont close your formatters, parser will create from it invalid AST and render it in red color

And that is all you should know about syntax of Documentation Parser. For more complex info, please check `Doc.scala` file - the declaration of Doc Parser's AST.

# TL;DR - Cheatsheet
- Tags - Created by typing
   - DEPRECATED
   - MODIFIED
   - ADDED
   - UPCOMING
   - REMOVED
- Sections
   - Raw - created automatically after two newlines, first line becomes title when used triple-newline instead of double.
   - Important - Just add `!` before the section title
   - Info - Just add `?` before the section title
   - Example - Just add `>` before the section title
- Links
   - normal URL's - Created with this syntax : `[Link name](URL)`
   - Image links - Created with this syntax : `![Image name](URL)`
- Lists - nestable by indentation
   - unordered - created by text indentation of 2 spaces with `-` marker
   - ordered - created by text indentation of 2 spaces with `*` marker
- Inline & Multiline code
   - inline code - enclose code in `` ` ``
   - multiline code - make an indentation from base indent of current section
- Text formatters - combineable
   - Italic - created by enclosing text with `_` mark, ex `_Foo_`
   - Bold - created by enclosing text with `*` mark, ex `*Foo*`
   - Strikeout - created by enclosing text with `~` mark, ex `~Foo~`
