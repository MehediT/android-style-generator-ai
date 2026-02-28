# TODO

## Chore

- [x] Change bucket name `fashion_product` to `default_image`
- [x] Remove `thumbnailUrl` in Supabase → rename to `thumbnailPath`
- [X] Change bucket policies for `fashion_product`
- [x] Rename `negative_prompt` in Supabase → `prompt`
- [x] Change bucket `fashion_product` to public

## Bug / Error Handling

- [x] Handle all errors from domain layer using `try-catch` and sealed `Exception` classes for logging or UI feedback
- [x] Handle UI error when `bytes: ByteArray` is null in `ImageDetailViewModel`

## Feature

- [ ] Cancel button when generation of image
- [ ] Show multiple error instead of one 
- [ ] Two-step flow before generating an image
- [ ] Download or share the generated picture
- [ ] Embed all prompts (or equivalent)
- [ ] Library of modified pictures
- [ ] Article screen — fetch product info from a website URL or marketplace link

## Animation
- [ ] Animation fade out error 
- [ ] 
